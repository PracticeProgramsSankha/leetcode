package com.FB40;

import com.datastructure.Utility;


/**
 * @author sanray on 4/25/2022
 */
public class P01_MoveZeros {
    public static void main(String[] args) {
        P01_MoveZeros sol = new P01_MoveZeros();
        sol.removeZeros(new int[] { 1, 10, 20, 0, 59, 63, 0, 88, 0 });

    }

    public void removeZeros(int[] nums) {
        Utility.printArray("Start", nums);
        int readIndex = nums.length - 1;
        int writeIndex = nums.length - 1;

        // Keep updating the write index if read index is Non-Zero
        while(readIndex >=0) {
            if(nums[readIndex] != 0) {
                nums[writeIndex] = nums[readIndex];
                writeIndex--;
            }
            readIndex--;
        }
        // Clear rest of the elements.
        while (writeIndex >=0) {
            nums[writeIndex--] = 0;
        }

        Utility.printArray("end", nums);
    }
}
