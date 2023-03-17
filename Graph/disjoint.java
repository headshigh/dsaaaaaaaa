class DisjointSet{
    List<Integer>rank=new ArrayList<>();
    List<Integer>parent=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findUpar(int node){
        if(node[parent]==node){
            return node;
        }
        int ulp=findUpar(parent[node]);
        parent.set(node,ulp)
        //path compression update parent so we don't have to do it again
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int ulp_u=findUpar(u);
        int ulp_v=findUpar(v);
        if(rank.get(ulp_u)>rank.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
        }
        else if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }
        else{//rank equal huda ultimate parent ko rank bada ani kunai auta ultimate parent ma conncet gar ek arka lai
            parent.set(ulp_v,ulp_u);//u ma connect garyo
            rank.set(ulp_u,rank.get(ulp_u)+1);
        }

    }
}
class Main{
    public static void main(String[] args) {
        DisjointSet ds=new DisjointSet(7);
        ds.unionByRank(1,2);
        ds.unionByRank(2,3);
        ds.unionByRank(4,5);
        ds.unionByRank(6,7);
        ds.unionByRank(5,6);
        if(ds.findUpar(3)==ds.findUpar(7)){
            System.out.println("same component");
        }else{
            System.out.println("Not same");
        }
        ds.unionByRank(3,7);
        if(ds.findUpar(3)==ds.findUpar(7)){
            System.out.println("same component");
        }else{
            System.out.println("Not same");
        }
    }
}