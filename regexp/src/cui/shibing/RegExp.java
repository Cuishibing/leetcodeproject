package cui.shibing;

public class RegExp {
    public static void main(String[] args) {
        System.out.println(new RegExp().isMatch("aaa", "a*ab"));
    }

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch(String s, String p, int sindex, int pindex) {
        int slen = s.length();
        int plen = p.length();
        if (sindex >= slen && pindex >= plen) {
            return true;
        }
        if (sindex < slen && pindex >= plen) {
            return false;
        }

        int nextPIndex = pindex + 1;
        if (nextPIndex < plen && p.charAt(nextPIndex) == '*') {
            if (sindex >= slen) {
                return isMatch(s, p, sindex, pindex + 2);
            }
            if (s.charAt(sindex) == p.charAt(pindex) || p.charAt(pindex) == '.') {
                return isMatch(s, p, sindex + 1, pindex) || isMatch(s, p, sindex, pindex + 2);
            } else {
                return isMatch(s, p, sindex, pindex + 2);
            }

        }
        if (sindex >= slen && pindex < plen) {
            return false;
        }
        if (s.charAt(sindex) != p.charAt(pindex) && p.charAt(pindex) != '.') {
            return false;
        } else {
            return isMatch(s, p, sindex + 1, pindex + 1);
        }


    }
}
