class Solution {
    public boolean isValidSerialization(String preorder) {
        // Split the string by commas to process node by node
        String[] nodes = preorder.split(",");
        
        // We start with 1 available slot for the root
        int slots = 1;
        
        for (String node : nodes) {
            // Each node (whether number or '#') consumes 1 slot
            slots--;
            
            // If slots become negative, it means we have nodes without a parent
            if (slots < 0) {
                return false;
            }
            
            // A non-null node creates 2 new slots for its potential children
            if (!node.equals("#")) {
                slots += 2;
            }
        }
        
        // A valid serialization must consume all available slots exactly
        return slots == 0;
    }
}
