package tutortAssignment
import scala.math._
import scala.collection.mutable.ListBuffer
object AssignmentWeek3 {
  def main(args: Array[String]): Unit = {
    var arr: Array[Int] = Array(10,7,4,8, 6, 5, 9)
    println("printing the last remaining element")
  }
  def maximumWealth(accounts: Array[Array[Int]]): Int = {
    var maxWealth = 0
    var outer_start = 0
    var outer_end = accounts.length-1
    while(outer_start <= outer_end ){
      var inner_start =0
      var inner_end = accounts(outer_start).length -1
      var sum = 0
      while (inner_start <= inner_end)
      {
        sum = sum + accounts(outer_start)(inner_start)
        inner_start += 1
      }
      if (sum > maxWealth)
      {
        maxWealth = sum
      }
      outer_start += 1
    }
    return maxWealth
  }
  def runningSum(nums: Array[Int]): Array[Int] = {
    var start =0
    var end = nums.length -1
    var sum = 0
    while (start <= end)
    {
      sum += nums(start)
      nums(start) = sum
      start += 1
    }
    return nums
  }

  def numJewelsInStones(jewels: String, stones: String): Int = {
    var jewelStart = 0
    var jewelEnd = jewels.length -1
    var count =0
    while (jewelStart <= jewelEnd)
    {
      var stoneStart = 0
      var stoneEnd = stones.length -1
      while(stoneStart <= stoneEnd)
      {
        if (jewels(jewelStart) == stones(stoneStart)) count += 1
        stoneStart += 1
      }
      jewelStart += 1
    }
    return count
  }
    def minimumAbsDifference(arr: Array[Int]): List[List[Int]] = {
      scala.util.Sorting.quickSort(arr)
      var start = 0
      var second =1
      var result = new ListBuffer[List[Int]]
      var end = arr.length -1
      var min = Int.MaxValue
      while(start <= end -1)
      {
        if(abs(arr(start)- arr(start +1)) < min)
        {
          min = abs(arr(start)- arr(start +1))
          result.clear()
          result += List(arr(start),arr(start+1))
        }
        else if (abs(arr(start)- arr(start +1)) == min) result += List(arr(start),arr(start+1))
        start += 1
      }
      result.toList
    }

  def threeConsecutiveOdds(arr: Array[Int]): Boolean = {
    var start = 0
    var end = arr.length -1
    var oddCount = 0
    var consecutive = false

    while (start <= end)
    {
      if (isOdd(arr(start)))
      {
        oddCount += 1
        if (oddCount >= 3) consecutive= true
      }
      else oddCount = 0
      start = start +1
    }
    return consecutive
  }

  def isOdd(num :Int) :Boolean ={
    if (num % 2 == 0) false
    else true
  }

  def majorityElement(nums: Array[Int]): Int = {
    //sorting can ensure that the element at middle is the one we are searching for
    scala.util.Sorting.quickSort(nums)
    var start = 0
    var end = nums.length -1
    var count = 0
    var result =0
    //Handling the edge case
    if (end == 0) result = nums(end)

    while(start <= end){
      if (nums(start) == result) count += 1
      else if (count == 0)
        {
          result = nums(start)
          count =1
        }
      else count -= 1
      start += 1
      //end -= 1
    }
    return result
  }
  def moveZeroes(nums: Array[Int]): Unit = {
    var insertPosition = 0
    var start =0
    var end = nums.length -1
    while(start <= end){
      if(nums(start) != 0)
      {
        nums(insertPosition) = nums(start)
        insertPosition += 1
      }
      start += 1
    }
    while (insertPosition < nums.length)
    {
      nums(insertPosition) = 0
      insertPosition += 1
    }
  }
}


//reverseArray