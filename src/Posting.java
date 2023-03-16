public class Posting {
    public Posting next = null;
    private int docId;
    private int dtf = 1; // document term frequency
    Posting(int docId){
        this.docId = docId;
    }
    public void addPosting(int docID){
        if(this.docId == docID){
            dtf ++;
            return;
        }
        if(this.next == null){
            this.next = new Posting(docID);
            return;
        }
        this.next.addPosting(docId);
    }

    public int getSize(){
        int size = 0;
        Posting it = this;
        while(it != null){
            size++;
            it = it.next;
        }
        return size;
    }

    public int getDocId(){
        return docId;
    }

    public void countdtf(){
        dtf++;
    }

    public void print(){
        System.out.println(String.format("document id: %2d \t\t document term frequency: %2d.", docId, dtf));
    }

    public void printAll(){
        Posting it = this;
        while(it != null){
            it.print();
            it = it.next;
        }
    }
}
