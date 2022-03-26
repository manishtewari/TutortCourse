package tutortAssignment

object AssignmentWeek1 {
  def main(args: Array[String]): Unit = {
    var arr: Array[Int] = Array(10,7,4,8, 6, 5, 9)
    //answer3
    /*println("array sum === " + answer1(arr)) //15
    println("array index value === " + answer2(arr, 1)) //15
    println("array Number === " + answer3(arr, 1))
    println("array alternate Numbers === " + answer4(arr))
    println("array alternate Numbers === " + answer5(arr))
    println("array perfect or Not? === " + answer6(arr))*/
    println("printing the last remaining element")
    answer8(arr)
    answer7(arr)
    answer9(10)
  }
  def reverseArray(Arr :Array[Int], left :Int, right :Int): Array[Int] =
  {
    if (Arr == null || Arr.length ==1)
      return Arr
    var start = left
    var end = right

    while (start < end)
    {
      var temp = Arr(start)
      Arr(start) = Arr(end)
      Arr(end) = temp
      start = start + 1
      end = end-1
    }
    return Arr
  }
  def answer1(array: Array[Int]): Int = {
    var start = 0
    var end = array.length - 1
    var sum = 0
    while (start <= end) {
      if (start == end) sum = sum + array(start)
      else sum = sum + array(start) + array(end)
      start = start + 1
      end = end - 1
    }
    return sum
  }

  def answer2(array: Array[Int], index: Int): Int = {
    var value = 0
    if (array.length - 1 >= index) value = array(index)
    else throw new IllegalArgumentException("Illegal Argument! default value being " + value)
    return value
  }

  def answer3(array: Array[Int], Number: Int): Int = {
    var start = 0
    var end = array.length - 1
    var numElement = 0
    var compNum = 1 * (-1)
    while (start <= end) {
      if (compNum != array(start)) {
        compNum = array(start)
        if (compNum <= Number) {
          start = start + 1
          numElement = numElement + 1
        }
      }
      else start = start + 1
    }
    return numElement
  }

  def answer4(array: Array[Int]): Unit = {
    var start = 0
    var end = array.length - 1
    while (start <= end) {
      if (start % 2 == 0)
        println(array(start))

      start = start + 1
    }
  }

  def answer5(array: Array[Int]): Unit = {
    var start = 0
    var end = array.length - 1
    while (start <= end) {
      if (start == array(start))
        println(array(start))
      start = start + 1
    }
  }

  def answer6(array: Array[Int]): Unit = {
    var start = 0
    var end = array.length - 1
    var perfect = true
    if (array == null || array.length ==1) {
      println("Perfect")
      System.exit(0)
    }
    while (start < end )
    {
      if (array(start) == array(end))
        {
          start = start + 1
          end = end-1
        }
      else
        {
          perfect = false
          end = end-1
          start = end
        }
    }
    if (perfect)
      println("Perfect")
    else
      println("Not Perfect")
  }

  def printArray(array : Array[Int], start : Int, end : Int)={
    var first =start
    var last = end
    while(first <= last)
      {
        println(array(first))
        first = first +1
      }
  }

  def swapArray(array : Array[Int], pos1 : Int, pos2 : Int) ={
    var temp = array(pos1)
    array(pos1) = array(pos2)
    array(pos2) = temp
  }
  //var arr: Array[Int] = Array(1, 2, 3, 4, 6, 5, 9)
  def partition(array : Array[Int], low :Int, high :Int): Int ={
    var pivot = array(high)
    var i = low -1
    var j = low

    while(j <= high -1)
    {
      if (array(j) < pivot)
      {
        i = i+1
        swapArray(array,i,j)
      }
      j=j+1
    }
    swapArray(array,i+1,high)
    return (i+1)
  }

  def sortArray(array : Array[Int],start : Int, end : Int): Array[Int] ={
    /*var low = 0
    var high = array.length -1*/
    if (start < end)
    { var pos = partition(array,start,end)

      sortArray(array,start, pos-1)
      sortArray(array,pos+1,end)
    }
    return array
  }
  def answer7(array: Array[Int]): Unit = {
    var start = 0
    var end = array.length - 1

    var sortedArray = sortArray(array, start, end)
    var length = sortedArray.length

    if (length ==1) println(array(1))
    else println(array((length-1)/2))
   // printArray(sortedArray, start, end - 2 )
  }

  def answer8(array: Array[Int]): Unit = {
    var start = 0
    var end = array.length - 1

    var sortedArray = sortArray(array, start, end)
    printArray(sortedArray, start, end - 2 )
  }
  def answer9(Number : Int): Unit = {
    println("Sum of element from 1 to "+Number+" = "+(Number*(Number+1)/2))
  }
}


//reverseArray