package ArraysAndStrings;

public class MinimumCommonValue {
    public static void main(String[] args) {

    }

    public int getCommon(int[] nums1, int[] nums2) {
        int j = 0 , i = 0;
        while (j < nums1.length && i < nums2.length){
            if (nums1[j] == nums2[i]){
                return nums1[j];
            }else if (nums1[j] < nums2[i]){
                j++;
            } else if (nums1[j] > nums2[i]){
                i++;
            }
        }
        return -1;
    }
}
