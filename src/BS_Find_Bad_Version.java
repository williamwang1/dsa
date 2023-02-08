

public class BS_Find_Bad_Version {

    public class SVNRepo {
        public boolean isBadVersion(int k) {
            return true;
        };
    }

    SVNRepo svnRepo = new SVNRepo();

    public int findFirstBadVersion(int n) {
        // write your code here
        if (n == 0) {
            return -1;
        }
        int start = 1;
        int end = n;
        // if (SVNRepo.isBadVersion(start)) {
        //     return start;
        // }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (svnRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (svnRepo.isBadVersion(start)) {
            return start;
        }
        if (svnRepo.isBadVersion(end)) {
            return end;
        }

        return -1;
    }
}

// https://www.lintcode.com/problem/first-bad-version/description
