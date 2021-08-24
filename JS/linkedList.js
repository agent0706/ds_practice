let linkedList = {};

const addNode = (value) => {
    if (!linkedList.value) {
        linkedList.value = value;
        linkedList.nextNode = null;
    } else {
        let tempNode = linkedList;
        while(tempNode.nextNode) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = {
            value,
            nextNode: null
        };
    }
};

const deleteNode = (value) => {
    if (linkedList.value === value) {
        linkedList = linkedList.nextNode ? linkedList.nextNode : {};
    } else {
        let tempNode = linkedList;
        let prevNode;
        let isMatchFound = false;
        while(tempNode.nextNode) {
            prevNode = tempNode;
            tempNode = tempNode.nextNode;
            if (tempNode.value === value) {
                isMatchFound = true;
                break;
            }
        }
        if (isMatchFound) {
            prevNode.nextNode = tempNode.nextNode;
        }
    }
};

const printList = () => {
    let tempNode = linkedList;
    while(tempNode) {
        console.log(tempNode.value);
        tempNode = tempNode.nextNode;
    }
}

const initLinkedList = (values) => {
    linkedList = {};
    values.forEach((value) => addNode(value));
}

initLinkedList([1, 4, 5, 7]);
deleteNode(1);
printList();