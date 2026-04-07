class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
		int l=(int)Math.log10(x);
		int dubli=x;
		int tempn=l;
		for(int i=1;i<=(l+1)/2;i++,x/=10)	{
			int a=(int)(((int)((dubli/Math.pow(10,tempn--)))%10));
			int b=x%10;
			if(a!=b)
				return false;
		}
        return true;
    }
}