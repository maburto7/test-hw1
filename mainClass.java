import java.text.DecimalFormat;

public class mainClass {
    public static void main(String[] args) {

        if(args.length != 2 ){System.exit(1);}
        
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);

        int num3 = num1-1;
        int num4 = num2-1;

        Triangle tr1 = new Triangle("FirstTriangle", num1, num2);
        Triangle tr2 = new Triangle("SecondTriangle", num1-1, num2-1);

    
        Circle c1 = new Circle("FirstCircle", num1);
        Circle c2 = new Circle("SecondCircle", num3);
    
 
        Square sq1 = new Square("FirstSquare", num1);
        Square sq2 = new Square("SecondSquare", num3);



        Rectangle rct1 = new Rectangle("FirstRectangle", num1, num2);
        Rectangle rct2 = new Rectangle("SecondRectangle", num1-1, num2-1);

        
        Picture pic = new Picture();
        pic.add(tr1);
        pic.add(tr2);
     
        pic.add(c1);
        pic.add(c2);

        pic.add(sq1);
        pic.add(sq2);

        
        pic.add(rct1);
        pic.add(rct2);

        
        pic.printAll();
        pic.drawAll();
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Total: " + df.format(pic.totalArea()));
        


    }
}

abstract class Shape {
    String name;

    DecimalFormat df = new DecimalFormat("#.##");

    public Shape(String name){ this.name = name; }

    public abstract void print();
    public void print(String msg) {
        System.out.println(name+ "(" + msg + ") : " + df.format(area()));}


    public void draw(){}

    public double area(){return 0.0;}

}

class Circle extends Shape{
    private int num1;

    public Circle(String name, int num1){
        super(name);
        this.num1 = num1;
    }

    public double area(){
        return Math.PI * num1 * num1;
    }

    public void draw(){
        System.out.println("  Circle");
        System.out.println("  ******* ");
        System.out.println(" *       *  ");
        System.out.println("*         * ");
        System.out.println("*         *  ");
        System.out.println(" *       *  ");
        System.out.println("  ******* ");

    }

    public void print(){
        super.print(Integer.toString(num1));
    }

}

class Square extends Shape{
    private int num1;

    public Square(String name, int num1){
        super(name);
        this.num1 = num1;
    }

    public double area(){return num1 * num1;}

    public void draw(){
        System.out.println("   Square");
        System.out.println(" ***********");
        System.out.println(" *         *");
        System.out.println(" *         *");
        System.out.println(" *         *");
        System.out.println(" ***********");
    }

    public void print(){ super.print(Integer.toString(num1));}

}

class Rectangle extends Square{
    private int num1, num2;

    public Rectangle(String name, int num1, int num2){
        super(name, num1);
        this.num1 = num1;
        this.num2 = num2;
    }

    public double area(){return num1 * num2;}

    public void draw(){
        System.out.println("   Rectangle");
        System.out.println(" **************");
        System.out.println(" *            *");
        System.out.println(" *            *");
        System.out.println(" **************");
    }

    public void print(){super.print(Integer.toString(num1) + ", " + Integer.toString(num2));}
    
   

}

class Triangle extends Shape{
    private int num1, num2;
    public Triangle(String name, int num1, int num2){
        super(name);
        this.num1 = num1;
        this.num2 = num2;
    }

    public double area(){return (double) (num1 * num2) / 2;}

    public void draw(){
        System.out.println("  Triangle");
        System.out.println("     *");
        System.out.println("    * *");
        System.out.println("   *   *");
        System.out.println("  *     *");
        System.out.println(" *       *");
        System.out.println("***********");

    }

    public void print(){
        super.print(Integer.toString(num1) + ", " + Integer.toString(num2));
    }

}

class ListNode {
    Shape info;
    ListNode next;

    public ListNode(Shape info, ListNode next){
        this.info = info;
        this.next = next;
    }
}


class Picture {
    ListNode head;

    public Picture(){this.head = null;}

    public void add(Shape s){
        ListNode newObj = new ListNode(s, null);
        if(isEmpty()) this.head = newObj;

        else{
            ListNode obj;
            for(obj = head; obj.next != null; obj=obj.next){}
            obj.next = newObj;}
        } 
        

    public int length(){
        int i = 0;
        for(ListNode obj = head; obj != null; obj=obj.next){
            i+= 1;}
            System.out.println(i);
            return i;
        }
    

    public boolean isEmpty(){ return this.head==null;}

    public void printAll(){
        for(ListNode curr = head; curr!=null; curr = curr.next ){;
            curr.info.print();
        }

    }

    public void drawAll(){
        for(ListNode curr = head; curr!=null; curr = curr.next){
            curr.info.draw();
        }
    }

    public double totalArea(){
        double totalArea = 0;
        for(ListNode curr = head; curr !=null; curr = curr.next){
            totalArea += curr.info.area();
        }
        return totalArea;
    }
}
