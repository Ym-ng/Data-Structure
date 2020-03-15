package VIVA_1_FRIDAY;

public class MyArrayList<T> {
    private T[] arr;
    private int size = 10;
    private int index = 0;
    public MyArrayList(){
//        if(t instanceof Integer){
//            arr = (T[])new Integer[size];
//        }else if(t instanceof Double){
//            arr = (T[])new Double[size];
//        }else if(t instanceof Character){
//            arr = (T[])new Character[size];
//        }else{
            arr = (T[])new Object[size];
//        }
    }
    public void add(T t){
        if(index < size){
            arr[index] = t;
            index ++;
        }else{
            size *= 2;
            T[] arr2 = (T[])new Object[size];
            for (int i = 0;i<arr.length;i++) {
                arr2[i] = arr[i];
            }
            arr2[index] = t;
            index++;
            arr2 = arr;
        }
    }
    public void add(T t,int pos){
        if(index < size){
            for (int i = index; i > pos; i--) {
                arr[i] = arr[i-1];
            }
            arr[pos] = t;
            index ++;
        }else{
            size *= 2;
            T[] arr2 = (T[])new Object[size];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            arr = arr2;
            for (int i = index; i > pos; i--) {
                arr[i] = arr[i-1];
            }
            arr[pos] = t;
            index ++;
        }
    }
    public T removeAt(int pos){
        T temp = arr[pos];
        for (int i = pos; i < arr.length; i++) {
            if(i==(arr.length-1)){
                arr[i] = null;
            }else{
                arr[i] = arr[i+1];
            }
        }
        index--;
        return temp;
    }
    public T get(int pos){
        if(pos<index){
            return arr[pos];
        }else{
            System.out.println("Invalid index to get element.");
            return null;
        }
    }
    public int size(){
        return index;
    }
    public String toString(){
        StringBuilder a = new StringBuilder("[");
        for (int i = 0; i < index-1; i++) {
            a.append(arr[i] + ",");
        }
        a.append(arr[index-1]);
        a.append("]");
        return new String(a);
    }
    public static void main(String[] args) {
        MyArrayList<Integer> in = new MyArrayList<>();
        in.add(1);
        in.add(2);
        in.add(3);
        in.removeAt(0);
        System.out.println("size of ArrayList: " + in.size());
        int index = 1;
        System.out.println("value at index " + index + " is " + in.get(index));
        in.add(6, 0);
        System.out.println(in.toString());
    }
}
