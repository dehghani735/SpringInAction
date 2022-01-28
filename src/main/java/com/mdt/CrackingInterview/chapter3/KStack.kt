//package com.mdt.CrackingInterview.chapter3
//
///**
// * A linked-list implementation of stack.
// * stack has four operations:
// * 1. pop()
// * 2. push(T t)
// * 3. peek()
// * 4. isEmpty()
// * date: 1/27/22
// *
// * @author mdt
// */
//class KStack<T> {
//    private var top: StackNode<T>? = null
//    @kotlin.Throws(Exception::class)
//    fun pop(): T {
//        if (top == null) throw Exception("Stack is Empty")
//        val data = top!!.data
//        top = top!!.next
//        return data
//    }
//
//    fun push(data: T) {
//        val node: StackNode<*> = StackNode<Any?>(data)
//        node.next = top
//        top = node
//    }
//
//    @kotlin.Throws(Exception::class)
//    fun peek(): T {
//        if (top == null) throw Exception("Stack is Empty")
//        return top!!.data
//    }
//
//    val isEmpty: Boolean
//        get() = top == null
//
//    private class StackNode<T>(private val data: T) {
//        private val next: StackNode<T>? = null
//    }
//}
