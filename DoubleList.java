/**双端链表实现，包括了链表添加，链表的插入删除，链表的正序逆序输出，链表的大小等方法
 * @author zhanxinlong
 * @since 1.0
 * @param <T> the type of elements held in this list
 */
public class DoubleList<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> rear;
    private int size;

    /**
     * @since 1.0
     * @return the size of list
     */
    public int getSize(){
        return size;
    }

    /**
     * the method of add element
     * @since 1.0
     * @param data the data in element
     */
    public void add(T data){
        if(head==null){
            DoubleNode<T> doubleNode = new DoubleNode<>(null, data, null);
            head=doubleNode;
            rear=doubleNode;
            size++;

        }else{
            DoubleNode<T> newDoubleNode = new DoubleNode<>(rear, data, null);
            rear.next=newDoubleNode;
            rear=newDoubleNode;
            size++;
        }
    }

    /**
     * the method of remove the element from this list
     * @since 1.0
     * @param data the data in the element
     */
    public void remove(T data){
        if(head==null){
            throw new RuntimeException("List is empty!");
        }else if (head.data==data){
            //remove the head node
            head=head.next;
            head.prev=null;
            size--;
        }else{
            DoubleNode<T> node=head;
            do {
                if(node.data==data){
                    if(node.next==null){
                        //remove the end node of the list
                        rear=node.prev;
                        rear.next=null;
                        size--;
                        break;
                    }else{
                        //remove the node and connect the prev Node of this node and the next Node of this node
                        DoubleNode<T> prev = node.prev;
                        DoubleNode<T> next = node.next;
                        prev.next=next;
                        next.prev=prev;
                        size--;
                        break;
                    }
                }else{
                    node=node.next;
                }
            }while(node!=null);
        }
    }
    public DoubleNode<T> remove(int index){
        DoubleNode<T> theNode=null;
        if(head==null){
            throw new RuntimeException("List is empty!");
        }else if(index==0){
            theNode=head;
            head=head.next;
            head.prev=null;
            size--;
        }else{
            if(index==(size-1)){
                //remove the end node of the list
                theNode=rear;
                rear=rear.prev;
                rear.next=null;
                size--;
            }else{
                DoubleNode<T> node=head;
                for (int flag = 0; flag < index; flag++) {
                    node=node.next;
                }
                theNode=node;
                DoubleNode<T> prev = node.prev;
                DoubleNode<T> next = node.next;
                prev.next=next;
                next.prev=prev;
                size--;
            }
        }
        return theNode;
    }

    /**
     *
     * @param index the place of insert node
     * @param data the data of insert node
     * @since 1.0
     */
    public void insert(int index,T data){
        if(head==null||index<0||index>size){
            throw new RuntimeException("List is empty or index out of boundary");
        }else if (index==0){
            //insert the head node
            DoubleNode<T> node = new DoubleNode<>(null, data, head);
            head.prev=node;
            head=node;
            size++;
        }else{
            //insert the node
            if(index==size){
                add(data);
            }else{
                DoubleNode<T> node=head;
                for (int flag = 0; flag < index-1; flag++) {
                    node=node.next;
                }
                DoubleNode<T> newNode=new DoubleNode<>(node,data,node.next);
                node.next.prev=newNode;
                node.next=newNode;
                size++;
            }
        }
    }

    /**
     * @since 1.0
     * @return output the String of this list
     */
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        if(head!=null){
            DoubleNode<T> node=head;
            do{
                stringBuilder.append(node.data+" ");
                node=node.next;
            }while(node!=null);
        }else{
            throw new RuntimeException("List is empty!");
        }
        return stringBuilder.toString();
    }

    /**
     * @since 1.0
     * @return output the String of the reverse list
     */
    public String toStringReverse(){
        StringBuilder stringBuilder = new StringBuilder();
        if(rear!=null){
            DoubleNode<T> node=rear;
            do{
                stringBuilder.append(node.data+" ");
                node=node.prev;
            }while(node!=null);
        }else{
            throw new RuntimeException("List is empty!");
        }
        return stringBuilder.toString();
    }
}

