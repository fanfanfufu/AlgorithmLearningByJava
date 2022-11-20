class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def sortOddEvenList(self,head):
        if not head or not head.next:
            return head
        oddList,evenList = self.partition(head)
        evenList = self.reverse(evenList)
        return self.merge(oddList,evenList)

    def partition(self, head: ListNode) -> ListNode:
        evenHead = head.next
        odd, even = head, evenHead
        while even and even.next:
            odd.next = even.next
            odd = odd.next
            even.next = odd.next
            even = even.next
        odd.next = None
        return [head,evenHead]
    def reverse(self,head):
        dumpy = ListNode(-1)
        p = head
        while p:
            temp = p.next
            p.next = dumpy.next
            dumpy.next = p
            p = temp
        return dumpy.next
    def merge(self,p,q):
        head = ListNode(-1)
        r = head
        while p and q:
            if p.val <= q.val:
                r.next = p
                p = p.next
            else:
                r.next = q
                q = q.next
            r = r.next
        if p:
            r.next = p
        if q:
            r.next = q
        return head.next