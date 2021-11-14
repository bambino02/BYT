from add import Add
from deduct import Deduct
from multiple import Multiple
from divide import Divide
from percent import Percent
operation1 = Add()
operation2 = Deduct(operation1)
operation3 = Divide(operation2)
operation4 = Multiple(operation3)
operation5 = Percent(operation4)

print(operation5.handle("55 % 5"))
#by '55%5' i mean 5% of 50
#s20897