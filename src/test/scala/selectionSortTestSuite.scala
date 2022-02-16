package org.sorting.examples

import org.scalatest.FunSuite

import scala.collection.mutable.ArrayBuffer

class selectionSortTestSuite extends FunSuite{

  test("selection sort on positive integers") {
    assert(selectionSort.execSelectionSort(ArrayBuffer(5,4,3,2,1)) == ArrayBuffer(1,2,3,4,5))
  }
  test("selection sort with negative integers") {
    assert(selectionSort.execSelectionSort(ArrayBuffer(5,4,3,-1,2,1)) == ArrayBuffer(-1,1,2,3,4,5))
  }
  test("selection sort with one integer") {
    assert(selectionSort.execSelectionSort(ArrayBuffer(5)) == ArrayBuffer(5))
  }
}
