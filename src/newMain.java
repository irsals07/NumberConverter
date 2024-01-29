public class newMain {
    public static void main(String[] args) {
        int[] nums = {1000, 0, 1, 99};
        int total = 1;
        int sum = nums[0];
        int min = nums[0];
        int max = nums[0];
        for(int i = 1; i<nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
            sum += nums[i];
            total++;
        }
        total -= 2;
        System.out.println(sum);
        System.out.println(min);
        System.out.println(max);
        System.out.println(total);
        System.out.println((sum - max - min) );
    }
}
