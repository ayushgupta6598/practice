package org.example.Code;

import java.util.*;

public class NMeetingsInOneRoom {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        int maxMeetings = Meetings.maxMeetings(start, end);
        System.out.println("Maximum number of meetings: " + maxMeetings);
    }
}

 class Meetings {
    static class Meeting {
        public int start;
        public int end;
        public int index;

        public Meeting(int _start, int _end, int _index) {
            this.start = _start;
            this.end = _end;
            this.index = _index;
        }
    }

    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public static int maxMeetings(int start[], int end[]) {
        ArrayList<Meeting> meeting = new ArrayList<>();

        for (int i = 0; i < start.length; i++) {
            meeting.add(new Meeting(start[i], end[i], i + 1));
        }

        Collections.sort(meeting, new MeetingComparator());

        int counter = 1;
        int limit = meeting.get(0).end;

        for (int i = 1; i < meeting.size(); i++) {
            if (meeting.get(i).start > limit) {
                limit = meeting.get(i).end;
                counter++;
            }
        }

        return counter;
    }

    static class MeetingComparator implements Comparator<Meeting> {
        @Override
        public int compare(Meeting m1, Meeting m2) {
            if (m1.end < m2.end) {
                return -1;
            } else if (m1.end > m2.end) {
                return 1;
            } else if (m1.index < m2.index) {
                return -1;
            }
            return 1;
        }
    }
}
