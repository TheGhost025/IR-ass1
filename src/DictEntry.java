
public class DictEntry {

    private int doc_freq = 0; // number of documents that contain the term
    private int term_freq = 0; //number of times the term is mentioned in the collection

    private Posting pList = null;


    public void addPosting(int doc_id) {

        term_freq++;
        if(pList == null){
            pList = new Posting(doc_id);
        }
        else {
            Posting it;
            boolean state=true;
            it=pList;
            while(it.next!=null){
                if(it.getDocId()==doc_id){
                    it.countdtf();
                    state=false;
                    break;
                }
                else{
                    Posting temp;
                    it=it.next;
                }
            }
            if(state){
                it.addPosting(doc_id);
            }
        }
        doc_freq = pList.getSize();
    }

    public void print(){
        System.out.println(String.format("Term frequency: %2d\nDocument Frequency: %2d\n", term_freq, doc_freq));
        pList.printAll();
        System.out.println("\n______________________________________________");
    }
}
