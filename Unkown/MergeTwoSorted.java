class MergeTwoSorted {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0, j=0, k=0;
        int[] ans= new int[n+m];

        while(i<m && j<n){
            if(nums1[i]<=nums2[j])
            {
                ans[k] = nums1[i];
                i++;
            }
            else if(nums1[i]>nums2[j])
            {
                ans[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i<m)
        {
            ans[k] = nums1[i];
            k++;
        }
        while(j<n)
        {
            ans[k] = nums2[j];
            k++;
        }
        System.out.print(ans);
    }
}