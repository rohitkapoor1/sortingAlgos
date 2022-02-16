package org.sorting.examples

import scala.collection.mutable.ArrayBuffer

/**
 * Selection Sort sorts an array by repeatedly finding the minimum element
 * from unsorted part and putting it at the beginning.
 */
object selectionSort extends App{

  if (args.nonEmpty) {
    val input = args(0)
  }
  else {
    throw new Exception("no input provided")
  }

  // input arguments will be Array[String], so we convert them to Array[Int]
  try {
    val input_list = args(0).split(",").map(_.toInt)
    execSelectionSort(input_list.to(ArrayBuffer)).foreach(println)
  }
  catch {
    case a: ArrayIndexOutOfBoundsException => println("ArrayIndexOutOfBoundsException")
    case n: NumberFormatException => println("error formatting inputs to numbers")
    case i: IndexOutOfBoundsException => println("IndexOutOfBoundsException:" + i.getMessage)
    case _: Throwable => println("Error processing")
  }

  def execSelectionSort(list: ArrayBuffer[Int]) : ArrayBuffer[Int] = {
    val sortedList: ArrayBuffer[Int] = ArrayBuffer()
    var smallestItem = list(0)
    var smallestItemIndex = 0
    if (list.length == 1) {
      list
    }
    else {
      for (i <- 0 until list.length) {
        // find smallest item and put in sortedLis
        smallestItemIndex = findSmallestItemIndex(list)
        smallestItem = list(smallestItemIndex)
        sortedList.addOne(smallestItem)
        list.remove(smallestItemIndex)
      }
      sortedList
    }
  }

  def findSmallestItemIndex(list: ArrayBuffer[Int]) : Int = {
    var smallestItemIndex = 0
    for (i <- 0 to list.length-1) {
      if (list(i) < list(smallestItemIndex)) {
        smallestItemIndex = i
      }
    }
    smallestItemIndex
  }

}
