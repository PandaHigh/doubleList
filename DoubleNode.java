public class DoubleNode<T> {
    DoubleNode<T> prev;
    T data;
    DoubleNode<T> next;
    public DoubleNode(){
        this(null,null,null);
    }
    public DoubleNode(DoubleNode<T> prev,T data,DoubleNode<T> next){
        this.prev=prev;
        this.data=data;
        this.next=next;
    }
}

