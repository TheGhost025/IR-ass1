public class Posting {
    public Posting next =null;
    int docId;
    int dtf=1;
    Posting(int id){
        docId=id;
    }

    public int getDocId(){
        return docId;
    }
}
