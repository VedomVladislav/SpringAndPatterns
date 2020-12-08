package adapter.adapter;

import adapter.objects.Printer;

import java.util.List;

//������� ��������� ������� ������� ���������� �� ������ ���� � ����������� ��������
public class PrinterAdapter implements PrintListPrinter {

    private Printer printer = new Printer();

    public void print(List<String> list) {
        for (String s: list) {
            printer.print(s);
        }
    }

}
