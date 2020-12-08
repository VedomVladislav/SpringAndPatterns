package adapter.objects;

import adapter.adapter.PrinterAdapter;

import java.util.ArrayList;
import java.util.List;


//Клиент использует адаптер, т.к. хочет работать с коллекцией, а принтер может печатать только одну строку
public class Client {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("text1");
        list.add("text2");
        list.add("text3");


        PrinterAdapter printerAdapter = new PrinterAdapter();
        printerAdapter.print(list);
    }


}
