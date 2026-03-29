class Solution {
    public boolean canBeEqual(String s1, String s2) {
        List<Character> list1 = new LinkedList<>();
        list1.add(s1.charAt(0));
        list1.add(s1.charAt(2));
        List<Character> list2 = new LinkedList<>();
        list2.add(s1.charAt(1));
        list2.add(s1.charAt(3));
        
        if(!list1.contains(s2.charAt(0))) return false;
        list1.remove((Character) s2.charAt(0));
        if(!list2.contains(s2.charAt(1))) return false;
        list2.remove((Character) s2.charAt(1));
        if(!list1.contains(s2.charAt(2))) return false;
        list1.remove((Character) s2.charAt(2));
        if(!list2.contains(s2.charAt(3))) return false;
        return true;

        
    }
}