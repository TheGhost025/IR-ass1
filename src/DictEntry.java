public class DictEntry {
    int doc_freg =0;
    int term_freg=0;
    Posting pList=null;

    public void addPosting(Posting p){
        if(pList==null){
            pList=p;
            term_freg++;
            doc_freg++;
        }
        else{
            Posting iterator;
            iterator =pList;
            boolean state=false;
            while (iterator.next!=null){
                if(p.getDocId()== iterator.getDocId()){
                    state=true;
                    break;
                }
                Posting temp=iterator.next;
                iterator=temp;
            }
            if(!state){
                iterator.next=p;
                term_freg++;
                doc_freg++;
            }
        }
    }
}
