class ProductOfNumbers {
    List<Integer>l;
    public ProductOfNumbers() {
        l=new ArrayList<>();
    }
    
    public void add(int num) {
        if(num!=0) l.add(num*(l.size()>0?l.get(l.size()-1):1));
        else l=new ArrayList<>();
    }
    
    public int getProduct(int k) {
        int n=l.size();
        if(n-k<0) return 0;
        return l.get(n-1)/((n-1-k>=0)?l.get(n-1-k):1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */