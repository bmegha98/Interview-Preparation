class GfG {
    // your required to complete this function
    // this function should return the encoded string
    // see the main function for the minHeapNode reference
    String decodeString(minHeapNode root, String encodedStr){
        int ind = 0;
        String res = "";
        minHeapNode curr = root;
        while(ind < encodedStr.length()) {
            while(curr != null) {
                if(curr.left == null && curr.right == null)
                {
                    res += String.valueOf(curr.data);
                    break;
                }
                char ch = encodedStr.charAt(ind);
                ind++;
                if(ch == '0')
                    curr = curr.left;
                else
                    curr = curr.right;
            }
            curr = root;
        }
        return res;
    }
}
