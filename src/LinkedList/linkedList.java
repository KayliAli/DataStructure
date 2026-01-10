package LinkedList;

public class linkedList {

    Eleman bas;
    Eleman son;

    linkedList(){
        bas=null;
        son=null;
    }
    void printList(){
        if(bas==null){ // liste boş
            return;
        }
        Eleman temp=this.bas;
        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.ileri;
        }
        System.out.println("------------------");
    }
    void addFrist(Eleman yeni){
        if(bas==null){ // liste bos
            bas=yeni;
            son=yeni;
            return;
        }
        Eleman tmp =bas;
        bas=yeni;
        yeni.ileri=tmp;

    }
    void addLast(Eleman yeni){
        if(bas==null){
            bas=yeni;
            son=yeni;
            return;
        }
        Eleman tmp =bas;
        while(tmp.ileri!=null){
            tmp=tmp.ileri;

        }
        tmp.ileri=yeni;
        son=yeni;
    }
    Boolean addBefore(Eleman target,Eleman yeni){
        if(bas==null){
            return false;
        }
        Eleman tmp =bas;
        while(tmp!=null){
            if(tmp.value==target.value){
                //Here
                if(tmp==son){
                    addLast(yeni);
                    return true;
                }
                Eleman temp2=tmp.ileri;
                tmp.ileri=yeni;
                yeni.ileri=temp2;
                return true;
            }
            tmp=tmp.ileri;
        }
        return false;
    }
    Eleman search(int target){
        if(bas==null){ //list empty
            return null;
        }
        Eleman tmp =bas;
        while(tmp!=null){
            if(tmp.value==target){
                return tmp; //this reference in memory
            }
            tmp=tmp.ileri;
        }
        return null;
    }
    void removeFirst(){
        if(bas==null){
            return;
        }
        bas=bas.ileri;

    }
    void removeLast(){
        if(bas==null){
            return;
        }
        Eleman tmp=bas;
        while(tmp!=son){
            if(tmp.ileri.ileri==null){
                son=tmp;
                tmp.ileri=null;
                return;
            }
            tmp=tmp.ileri;
        }
    }
    linkedList clonList(linkedList list){

        linkedList clonList=new linkedList();
        Eleman tmp=list.bas;
        if(tmp==null){
            return clonList;
        }
        while (tmp!=null){
            Eleman cloned=new Eleman(tmp.value);
            clonList.addLast(cloned);
            tmp=tmp.ileri;
        }
        return  clonList;
    }

}
