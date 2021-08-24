const linkedList = {};

const addNode = (value) => {
    if (Object.keys(linkedList).length) {
        let temp = linkedList;
        while(temp.nextNode) {
            temp = temp.nextNode;
        }
        temp.nextNode = {
            nextNode: null,
            value: value
        };
    } else {
        linkedList.value = value;
        linkedList.nextNode = null;
    }
};

const initList = (values) => {
    if (!Object.keys(linkedList).length) {
        linkedList.nextNode = null;
        linkedList.value = values[0];
    } else {
        console.log('linked list is already initalised');
        return;
    }
    let temp = linkedList;
    for (let i = 1; i < values.length; i++) {
        temp.nextNode = {
            nextNode: null,
            value: values[i]
        };
        temp = temp.nextNode;
    }
};

const deleteNodeRecursive = (value, node, prevNode) => {
    if (!Object.keys(linkedList).length) {
        console.log('Linked list is empty');
        return;
    }
    if (node.value === value) {
        prevNode.nextNode = node.nextNode;
    } else {
        deleteNodeRecursive(value, node.nextNode, node);
    }
};

const printList = () => {
    let temp = linkedList;
    while(temp) {
        console.log(temp.value);
        temp = temp.nextNode;
    }
};

initList([1, 5, 3, 6]);
addNode(5);
deleteNodeRecursive(3, linkedList)
printList();

