from operation import Operation


class Divide(Operation):
    def handle(self, input):
        symbol = input.split()
        while True:
            try:
                if symbol[1] == '/' or symbol[1] == ':' :
                     print("Result: ")
                     return int(symbol[0]) / int(symbol[2])
                     break
                elif self._status is not None:
                     return self._status.handle(input)
                else:
                    print("This math operation is not supported :(")
                    return None

            except:
                print("Please insert an appropriate data!")
                break