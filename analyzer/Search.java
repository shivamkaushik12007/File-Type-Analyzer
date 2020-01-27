package analyzer;
public class Search {
    public int naive(String s1,String s2){
        int i=0;
        int mnt=0;
        while(i<s1.length()){
            int j=0;
            int k=i;
            int cnt=0;
            while(j<s2.length()){
                if(s1.charAt(k)==s2.charAt(j)){
                    j++;
                    k++;
                    cnt++;
                }else {
                    break;
                }
            }
            if(cnt==s2.length()){
                mnt++;
                break;
            }
            i++;
        }
        if(mnt>0)
            return 1;
        return 0;
    }

    public int KMP(String pat, String txt){
        int M = pat.length();
        int N = txt.length();
        int lps[] = new int[M];
        int j = 0;

        computeLPSArray(pat, M, lps);

        int i = 0;
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                return 1;
            }
            else if (i < N && pat.charAt(j) != txt.charAt(i)){
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return 0;
    }

    public void computeLPSArray(String pat, int M, int lps[]){
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }else{

                if (len != 0) {
                    len = lps[len - 1];
                }else{
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}


