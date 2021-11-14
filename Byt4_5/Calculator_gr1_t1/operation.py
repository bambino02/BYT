from  abc import abstractmethod


class Operation:
    def __init__(self, status=None):
        self._status = status

    @abstractmethod

    def handle(self, input):
        pass