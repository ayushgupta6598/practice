package org.example.java8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * ❌ Why Transaction WILL NOT work here:
 *
 * Spring uses proxy-based AOP (Aspect-Oriented Programming) to apply transactional behavior.
 * When you call secondMethod() from within the same class (i.e., firstMethod() calls secondMethod()),
 * the call does not go through the Spring proxy.
 * As a result, the @Transactional annotation on secondMethod() is ignored.
 *
 * ----------------------------
 * ✅ When will the transaction work?
 *
 * To make the transaction work, you need to ensure the call goes through the Spring proxy.
 * Here are two ways to do that:
 *
 * ✔ Option 1: Call from another Spring-managed bean (using self-injection)
 *
 * @Component
 * public class Main {
 *
 *     @Autowired
 *     private Main self; // Inject the proxy of this class
 *
 *     public Integer firstMethod() {
 *         return self.secondMethod(); // ✅ Goes through proxy, so @Transactional applies
 *     }
 *
 *     @Transactional
 *     public Integer secondMethod() {
 *         // logic
 *         throw new RuntimeException(); // Must be unchecked for rollback
 *     }
 * }
 *
 * ✔ Option 2: Move the transactional method to another class
 *
 * @Component
 * public class AnotherService {
 *
 *     @Transactional
 *     public Integer secondMethod() {
 *         // logic
 *         throw new RuntimeException(); // Unchecked exception triggers rollback
 *     }
 * }
 *
 * @Component
 * public class Main {
 *
 *     @Autowired
 *     private AnotherService anotherService;
 *
 *     public Integer firstMethod() {
 *         return anotherService.secondMethod(); // ✅ Goes through proxy
 *     }
 * }
 *
 * ⚠️ Additional Notes:
 * - Spring rolls back only on unchecked exceptions (RuntimeException and its subclasses) by default.
 * - If you throw a checked exception (like new Exception()), it won’t cause a rollback
 *   unless you explicitly configure it with:
 *     @Transactional(rollbackFor = Exception.class)
 *
 * ✅ Summary:
 *
 * Scenario                                       | Will Transaction Work?
 * --------------------------------------------- | -----------------------
 * Calling @Transactional method internally       | ❌ No
 * Calling through self-injected proxy            | ✅ Yes
 * Calling from another Spring bean               | ✅ Yes
 * Throwing checked exception without config      | ❌ No rollback
 * Throwing unchecked (runtime) exception         | ✅ Rollback works
 */
@Component
public class TransactionalExample {

    public Integer firstMethod() {
        return secondMethod(); // ❌ Will not be transactional
    }

    @Transactional
    public Integer secondMethod() {
        throw new RuntimeException(); // Unchecked, but won't rollback due to direct call
    }
}
