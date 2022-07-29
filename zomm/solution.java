package zomm;

import java.util.LinkedList;

public class solution {
    class AnimalShelf {

        //创建队列分别存储狗和猫
        LinkedList<int[]> dogs, cats;

        public AnimalShelf() {
            dogs = new LinkedList<>();
            cats = new LinkedList<>();
        }

        public void enqueue(int[] animal) {
            //添加猫
            if(animal[1] == 0){
                cats.add(animal);
                return;
            }
            //添加狗
            dogs.add(animal);
        }

        public int[] dequeueAny() {
            //没有收养动物
            if(dogs.isEmpty() && cats.isEmpty()){
                return new int[]{-1, -1};
            }
            //没有狗
            if(dogs.isEmpty()){
                int[] res = cats.get(0);
                cats.remove(0);
                return res;
            }
            //没有猫
            if(cats.isEmpty()){
                int[] res = dogs.get(0);
                dogs.remove(0);
                return res;
            }
            //都有，返回编号最小的
            int[] cat = cats.get(0), dog = dogs.get(0);
            //猫小
            if(cat[0] < dog[0]){
                cats.remove(0);
                return cat;
            }
            //狗小
            dogs.remove(0);
            return dog;
        }

        public int[] dequeueDog() {
            //没有狗
            if(dogs.isEmpty()){
                return new int[]{-1, -1};
            }
            //有狗
            int[] res = dogs.get(0);
            dogs.remove(0);
            return res;
        }

        public int[] dequeueCat() {
            //没有猫
            if(cats.isEmpty()){
                return new int[]{-1, -1};
            }
            //有猫
            int[] res = cats.get(0);
            cats.remove(0);
            return res;
        }
    }

}
