package com.base.warecenter;

import lombok.Data;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class MathTest {
    public static void main(String[] args) {
        int[] reQueue =  {12,3,2,44,55,66,32,99,23,42};
        reQueue = heapSort(reQueue);
    }

    private static void creatTree(ComplementTree root, int[] reQueue, int rootIndex) {
        if (rootIndex <= reQueue.length / 2 - 1) {

            if (reQueue.length - 1 >= rootIndex * 2 + 1) {
                root.setLeft(new ComplementTree(reQueue[rootIndex * 2 + 1]));
            }
            if (reQueue.length - 1 >= rootIndex * 2 + 2) {
                root.setRight(new ComplementTree(reQueue[rootIndex * 2 + 2]));
            }

            if (reQueue.length - 1 >= rootIndex * 2 + 1) {
                creatTree(root.left, reQueue, rootIndex * 2 + 1);
            }
            if (reQueue.length - 1 >= rootIndex * 2 + 2) {
                creatTree(root.right, reQueue, rootIndex * 2 + 2);
            }
        }
    }
    private static void heapAdjust(int[] reQueue,int start,int end){
        int length = end-start+1;
        for (int i = end; i >= start; i--) {
            int rootValue = reQueue[i];
            int left = length - 1 >= i * 2 + 1 ? reQueue[i * 2 + 1] : 0;
            int right = length - 1 >= i * 2 + 2 ? reQueue[i * 2 + 2] : 0;
            int temp = -1;
            //如果左边大于右边
            if (left > right) {
                if (rootValue < left) {
                    //交互左子树和根节点
                    if (length - 1 >= i * 2 + 1) {
                        temp = rootValue;
                        reQueue[i] = left;
                        reQueue[i * 2 + 1] = temp;
                    }
                }
            } else {
                if (rootValue < right) {
                    //交互右子树和根节点
                    if (length - 1 >= i * 2 + 2) {
                        temp = rootValue;
                        reQueue[i] = right;
                        reQueue[i * 2 + 2] = temp;
                    }
                }
            }
        }
    }

    private static int[] heapSort(int[] reQueue) {
        //1、建立一个完成二叉树
        ComplementTree root = new ComplementTree(reQueue[0]);
        creatTree(root, reQueue, 0);
        System.out.println("排序前：");
        firstPrint(root);

        //2、从后往前查找,从最后一个非叶子节点开始，判断左子树和根节点以及右子树的大小，选最大的，交换当前节点的值
        int start = 0;
        int end = reQueue.length -1;
        for (int i = 0; i < reQueue.length; i++) {
            heapAdjust(reQueue,start,end);
            int temp = reQueue[start];
            reQueue[start] = reQueue[end];
            reQueue[end] = temp;
            end --;
        }
        root = new ComplementTree(reQueue[0]);
        System.out.println("");
        creatTree(root, reQueue, 0);
        System.out.println("排序后：");
        gradationPrint(root);

        return reQueue;
    }

    /**
     * 先根
     * @param tree
     */
    private static void firstPrint(ComplementTree tree){
        if (!ObjectUtils.isEmpty(tree)){
            System.out.print("\t" +tree.getValue());
            firstPrint(tree.getLeft());
            firstPrint(tree.getRight());
        }
    }
    private static   Queue<ComplementTree> queue = new LinkedList<>();
    /**
     * 层次遍历
     * @param tree
     */
    private static void gradationPrint(ComplementTree tree){
        if (!ObjectUtils.isEmpty(tree)){
            queue.add(tree);
            while(!queue.isEmpty()){
                ComplementTree poll = queue.poll();
                System.out.print("\t" +poll.getValue());
                if (!ObjectUtils.isEmpty(poll.getLeft())){
                    queue.add(poll.getLeft());
                }
                if (!ObjectUtils.isEmpty(poll.getRight())) {
                    queue.add(poll.getRight());
                }
            }
        }
        System.out.println("");
    }
    @Data
    private static class ComplementTree {
        //节点的值
        private int value;
        //左节点
        private ComplementTree left;
        //右节点
        private ComplementTree right;

        public ComplementTree(int value) {
            this.value = value;
        }
    }
}
