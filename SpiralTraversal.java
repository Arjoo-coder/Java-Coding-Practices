import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        // Base case check
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        // Initialize boundaries
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        // Loop until boundaries cross each other
        while (top <= bottom && left <= right) {
            
            // 1. Move Left to Right (along the Top row)
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++; // Move top boundary down

            // 2. Move Top to Bottom (along the Right column)
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move right boundary left

            // 3. Move Right to Left (along the Bottom row)
            if (top <= bottom) { // Double-check to avoid repeating processed rows
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--; // Move bottom boundary up
            }

            // 4. Move Bottom to Top (along the Left column)
            if (left <= right) { // Double-check to avoid repeating processed columns
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move left boundary right
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Example 4x4 matrix
        int[][] matrix = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9,  10, 11, 12},
            {13, 14, 15, 16}
        };

        List<Integer> spiralList = spiralOrder(matrix);
        System.out.println("Spiral Order Traversal: " + spiralList);
    }
}
