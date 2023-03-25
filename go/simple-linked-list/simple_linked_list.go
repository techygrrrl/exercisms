package linkedlist

import "fmt"

type List struct {
	innerList []int
	Length    int
	Head      *Node
	Tail      *Node
}

type Node struct {
	Value    int
	Next     *Node
	Previous *Node
}

type ListError struct {
	Message string
}

func (e *ListError) Error() string {
	return fmt.Sprintf("ListError: %s", e.Message)
}

func New(elements []int) *List {
	linkedList := &List{
		innerList: elements,
		Length:    len(elements),
		Head:      nil,
		Tail:      nil,
	}

	for i, n := range elements {
		newNode := Node{Value: n}

		if i == 0 {
			linkedList.Head = &newNode
			linkedList.Tail = &newNode
			continue
		}

		if i == 1 {
			linkedList.Head.Next = &newNode
		}

		previousTail := linkedList.Tail

		newNode.Previous = previousTail
		previousTail.Next = &newNode
		linkedList.Tail = &newNode
	}

	return linkedList
}

func (l *List) Size() int {
	return l.Length
}

func (l *List) Push(element int) {
	l.Length++
	newNode := Node{Value: element}
	l.innerList = append(l.innerList, element)

	previousTail := l.Tail

	if previousTail != nil {
		previousTail.Next = &newNode
		newNode.Previous = previousTail
	}

	l.Tail = &newNode
}

func (l *List) Pop() (int, error) {
	if l.Length == 0 {
		return 0, &ListError{"List is empty"}
	}

	l.innerList = l.innerList[:len(l.innerList)-1]

	if l.Length == 1 {
		value := l.Tail.Value
		l.Head = nil
		l.Tail = nil
		l.Length = 0
		return value, nil
	}

	previousTail := l.Tail
	value := previousTail.Value

	l.Length--

	l.Tail = previousTail.Previous
	l.Tail.Next = nil

	return value, nil
}

func (l *List) Array() []int {
	return l.innerList
}

func (l *List) Reverse() *List {
	var reversedInner = make([]int, len(l.innerList))

	lastIndex := len(l.innerList) - 1
	targetIndex := 0
	for i := lastIndex; i >= 0; i-- {
		reversedInner[targetIndex] = l.innerList[i]
		targetIndex++
	}

	l.innerList = reversedInner
	newList := New(reversedInner)

	return newList
}
