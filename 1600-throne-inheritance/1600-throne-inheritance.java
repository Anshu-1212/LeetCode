class ThroneInheritance {
    List<String>l;
    String root;
    Map<String,List<String>>map;
    Set<String>dead;
    public void preOrder(String root){
        if(root==null) return;
        if(!dead.contains(root))l.add(root);
        if(!map.containsKey(root)) return;
        for(String e:map.get(root)){
            preOrder(e);
        }
    }
    public ThroneInheritance(String kingName) {
        root=kingName;
        map=new HashMap<>();
        dead=new HashSet<>();
    }
    
    public void birth(String parentName, String childName) {
        if(map.containsKey(parentName)) map.get(parentName).add(childName);
        else{
            map.put(parentName,new ArrayList<>());
            map.get(parentName).add(childName);
        } 
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        l=new ArrayList<>();
        preOrder(root);
        return l;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */