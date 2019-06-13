package com.fuqi.month05.day0528;

/**
 * @Description: 得到两个排好序的数组的中位数，要求时间复杂度为O(log(m+n))
 * @Author 傅琦
 * @Date 2019/5/28 20:44
 * @Version V1.0
 */
public class MedianNumberOfTwoArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if(m > n){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            int tempN = m;
            m = n;
            n = tempN;
        }

        int iMin = 0, iMax = m, halfLen = (m+n+1) / 2;

        while(iMin <= iMax){
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;

            if(i < iMax && nums2[j-1] > nums1[i]){
                iMin = i + 1;
            }else if( i > iMin && nums1[i-1] > nums2[j]){
                iMax = i - 1;
            }else{
                int maxLeft = 0;
                if(i == 0){maxLeft = nums2[j-1];}
                else if(j == 0){maxLeft = nums1[i-1];}
                else{ maxLeft = Math.max(nums1[i-1], nums2[j-1]);}
                if((m+n) % 2 == 1){return maxLeft;}

                int minRight = 0;
                if(i == m){minRight = nums2[j];}
                else if(j == n){minRight = nums1[i];}
                else{minRight = Math.min(nums1[i], nums2[j]);}

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
