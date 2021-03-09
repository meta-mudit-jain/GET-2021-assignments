package com.dsa4;

import java.util.*;
public class VirtualCP {
    public static class TreeNode{
        public String val;
        public String addr;
        public Date date;
        public int level;
        public List<TreeNode> children=new LinkedList<>();
        public TreeNode parent;
        public TreeNode(String data,TreeNode parent){
            val=data;
            this.parent=parent;
            date=new Date();
            if(parent==null){
                this.addr=data;
                this.level=1;
            }
            else{
                this.addr=this.parent.addr+"\\"+data;
                this.level=parent.level+1;
            }
        }
    }
    public static TreeNode root=new TreeNode("A:\\",null);
    public static TreeNode curDir=root;

    public static TreeNode find(TreeNode node,String file){
        if(node==null){
            return null;
        }
        TreeNode res=null;
        List<TreeNode> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int n=q.size();
            while(n>0){
                int index=0;
                TreeNode p=q.remove(index);
                if(file.equals(p.val) && curDir.val.equals(p.parent.val))
                {
                    res=p;
                    break;
                }
                for(int i=0;i<p.children.size();i++)
                    q.add(p.children.get(i));
                n--;
            }

        }
        return res;
    }

    public static List<TreeNode> findAll(TreeNode node,String file){
        if(node==null){
            return null;
        }
        List<TreeNode> res=new ArrayList<>();
        List<TreeNode> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int n=q.size();
            while(n>0){
                int index=0;
                TreeNode p=q.remove(index);
                if(file.equals(p.val))
                {
                    res.add(p);
                }
                for(int i=0;i<p.children.size();i++)
                    q.add(p.children.get(i));
                n--;
            }

        }
        return res;
    }



    public static void print(TreeNode node){
        if(node==null){
        }
        List<TreeNode> q=new ArrayList<>();
        q.add(node);
        int level=1;
        while(!q.isEmpty()){
            int index=q.size()-1;
            TreeNode curr=q.remove(index);
            if(curr!=null){
                if(curr==root){
                    System.out.println(curr.val);
                }
                else{
                    System.out.print("|");
                    for(int j=0;j<curr.level-2;j++)
                        System.out.print("\t");
                    System.out.println("|----"+curr.val);
                }
                for(int i=curr.children.size()-1;i>=0;i--)
                    q.add(curr.children.get(i));

            }
        }

    }

    public static void mkdir(String file){
        TreeNode temp=find(root,file);
        if(temp==null){
            curDir.children.add(new TreeNode(file,curDir));
        }
        else{
            System.out.println("Directory already exists");
        }
    }
    public static void cd(String file){
        TreeNode temp=find(curDir,file);
        if(temp==null)
            System.out.println("No such directory");
        else{
            curDir=temp;
        }
    }
    public static void bk(){
        if(curDir==root){
            System.out.println("This is root don't have any parent");
        }
        else{
            curDir=curDir.parent;
        }

    }
    public static void findFile(String file){
        List<TreeNode> temp=new ArrayList<>();
        temp=findAll(curDir,file);
        if(temp.isEmpty())
            System.out.println("No such file");
        else{
            for(int i=0;i<temp.size();i++)
                //System.out.println(temp.get(i).date+" "+temp.get(i).parent.val+temp.get(i).val+">");
                System.out.println(temp.get(i).date+" "+temp.get(i).addr+">");
        }
    }
    /*public static void print(){
        boolean[] flag=new boolean[100];
        Arrays.fill(flag, false);
        printTree(root,flag,0,false);
    }*/
    public static void ls(TreeNode node){
        if(node==null){
        }
        List<TreeNode> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int n=q.size();
            while(n>0){
                int index=0;
                TreeNode p=q.remove(index);
				/*if(p==root)
					System.out.print(p.val+" ");
				else
				   System.out.print(p.parent.val+p.val+">");*/
                System.out.print(p.date+" "+p.addr+">");
                for(int i=0;i<p.children.size();i++)
                    q.add(p.children.get(i));
                n--;
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int a=1;
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to VCP");
        while(a!=0){
            String ans="";
            System.out.print(curDir.addr+">");
            ans=sc.nextLine();
            String token[]=ans.split(" ");
            switch(token[0]){
                case "mkdir": mkdir(token[1]);
                    break;
                case "cd" :  cd(token[1]);
                    break;
                case "bk" :   bk();
                    break;
                case "ls" :   ls(curDir);
                    break;
                case "find" : findFile(token[1]);
                    break;
                case "tree" : print(root);
                    break;
                case "exit" : System.out.println("Thanks for using!!");
                    a=0;
                    break;
                default : System.out.println("You entered wrong commnad.");
            }
        }
    }

}
