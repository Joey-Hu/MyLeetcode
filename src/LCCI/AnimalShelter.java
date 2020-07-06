package LCCI;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: huhao
 * @time: 2020/7/6 14:48
 * @desc: https://leetcode-cn.com/problems/animal-shelter-lcci/
 */
public class AnimalShelter {
    /**
     * 使用两个用linkedList实现的队列，一个放狗，一个放猫
     *
     * Queue接口分析：add和offer区别，remove和poll方法到底啥区别
     * https://www.cnblogs.com/hetaoyuan/p/11392167.html
     */
    private Queue<int[]> dogs;
    private Queue<int[]> cats;

    public AnimalShelter() {
        dogs = new LinkedList<int[]>();
        cats = new LinkedList<int[]>();
    }

    public void enqueue(int[] animal) {
        if(animal[1] == 0){
            cats.offer(animal);
        }else if(animal[1] == 1){
            dogs.offer(animal);
        }
    }

    public int[] dequeueAny() {
        if(cats.isEmpty() && dogs.isEmpty()){
            return new int[]{-1, -1};
        }
        if(cats.isEmpty() || dogs.isEmpty()){
            return cats.isEmpty() ? dogs.poll() : cats.poll();
        }
        // 如果两个队列都不为空，选择最老的
        int[] cat = cats.peek();
        int[] dog = dogs.peek();
        if(cat[0] > dog[0]){
            return dogs.poll();
        }else {
            return cats.poll();
        }
    }

    public int[] dequeueDog() {
        if(dogs.isEmpty()){
            return new int[]{-1, -1};
        }else{
            return dogs.poll();
        }
    }

    public int[] dequeueCat() {
        if(cats.isEmpty()){
            return new int[]{-1, -1};
        }else {
            return cats.poll();
        }
    }
}
