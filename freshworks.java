import java.util.Hashmap;
import java.util.Scanner.*;
import java.io.*;

class backEnd
{
    Hashtable<String,JsonObject> ht=new Hashtable<String,JsonObject>();
    JsonObject jo=new JsonObject();
    int value;
    FileReader fr1;
    BufferedReader br1;
    BufferedWriter bw1;
    File f1;  
    final long SIZE_1GB=10737412824L; 
    Gson g=g=new Gson();
    Scanner sc=new Scanner(System.in);
    backEnd()
      {  String k=sc.next(); //key
         String v=sc.next();  //value
      }
    synchronized public void createFile()
    {
      try
      {
          f1=new File("D:\\doctor.txt");
          fr1=new FileReader(f1);
          br1=new BufferedReader(fr1);
          bw1=new BufferedWriter(new OutputStreamWriter(new LimitedOutputStream(f1.newOutputStream("D:\\"),SIZE_1GB,StandardCharsets.UTF_8)));
      }
      catch(Exception ex){ }
    }
       
    synchronized addKeyValue() 
    {    
        try
           {
          String str1=g.toJson(v);

           if(!ht.containsKey(k)) {ht.put(k,str1); }   //write operation performed if current key does not exist in the  hash table
        
          
           else   // else throw exception
               { 
                 throw DuplicateKeyException;
               }
           }

     }
    synchronized readKey()
    {
          try{
           if(br1.readLine()!=null)   //read operation based on key
               {
                  if(ht.containsKey(k))
                    {
                      jo=ht.get(k);
                     }
               } 
             }
         catch(Exception ex)  {}
    }
   synchronized deleteKey()
    {  
            
           if(br1.readLine()!=null)  //delete operation based on key
           {   
              if(ht.containsKey(k))
                  { 
                      ht.remove(k);
                  }
           } 
      }
        catch(Exception ex){} 
}
synchronized public String deleteKey(long timeout,int key)
{
    long t=0;
    while(t!=timeout)
    {
        t+=1;
     }
    if(t>=timeout) 
     {
         String st=(String)ht.remove(key);
      }
      return st;
}

public static void main(String ars[])
{
   backEnd be=new backEnd();
   be.createAddDelete();
   be.deleteKey(100,10);
}
}   
   
   



         
    
     
    
    