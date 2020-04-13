object MySimulation extends CircuitSimulation {
  def InverterDelay = 2

  def AndGateDelay = 8

  def OrGateDelay = 6

  def main(args: Array[String]): Unit = {
    val input1, input2, sum, carry = new Wire
    probe("sum", sum)
    probe("carry", carry)
    halfAdder(input1, input2, sum, carry)
    input1 setSignal true
    run()
    input2 setSignal true
  }

}
