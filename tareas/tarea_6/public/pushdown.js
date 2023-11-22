const STATES = {
  p: 'p',
  q: 'q',
  f: 'f'
}

class Node {
  data
  nextNode
  id
  constructor(
    id,
    data = 'Z',
    next = null
  ) {
    this.id = id
    this.data = data;
    this.nextNode = next 
  }
}

class Stack {
  root = new Node()
  top = this.root
  state = STATES.q

  push(id, data) {
    const newNode = new Node(id, data)
    this.top.nextNode = newNode
    this.top = newNode
  }

  isEmpty() {
    if (this.top.data == 'Z') {
      return true
    }

    return false
  }

  pop() {
    if (this.isEmpty()) {
      throw "Stack is empty"
    }
    this.state = STATES.p
    let prev
    let current = this.root
    while (current.nextNode) {
      prev = current
      current = current.nextNode
    }
    prev.nextNode = null
    this.top = prev
    return current
  }
}
let moveLen = 0

const sleep = (milliseconds) => {
  return new Promise(resolve => setTimeout(resolve, milliseconds))
}

function move () {
  anime({
    targets: '.reader-content',
    translateX: moveLen += (-310),
  });
}

function createNodeStack (id, data) {
  const node = document.createElement('div')
  node.id = id
  node.className = 'pushdown-stack-item'
  node.textContent = data
  stackDiv.appendChild(node)
}

function removeNodeStack (id) {
  const nodeToRemove = document.getElementById(id)
  nodeToRemove.classList.add("removeItemAnimation");
  nodeToRemove.addEventListener("animationend", function () {
    stackDiv.removeChild(nodeToRemove);
  });
}

function successState() {
  const stackStateDiv = document.getElementById('state')
  stackStateDiv.classList.add('push-success') 
}

function errorState() {
  const stackStateDiv = document.getElementById('state')
  stackStateDiv.classList.add('push-error')
}

function getInstantaneus(i) {
  return `(${i.state}, ${ i.input.join('')}, ${i.stack.join('')})`
}

function printInstantaneus(i) {
  console.log(`(${i.state}, ${ i.input.join('')}, ${i.stack.join('')})`)
}

async function start() {
  const instantaneusList = []
  const instantaneus = {
    state: '',
    input: [],
    stack: []
  };
  const stack = new Stack()
  const inputData = document.getElementById('data')
  if(inputData.value.length == 0) {
    return
  }
  state.innerText = stack.state
  content.innerText = inputData.value
  instantaneus.state = stack.state;
  instantaneus.input = inputData.value.split('')
  instantaneus.stack.push('z0')

  let counter = 0
  while(counter < inputData.value.length) {
    const currentChar = inputData.value[counter]
    if(currentChar === '0') {
      stack.push(counter, 'X')
      createNodeStack(counter, 'X')
      instantaneus.state = stack.state;
      instantaneus.input.shift()
      instantaneus.stack.unshift('X')
    } else {
      try {
        const element = stack.pop()
        removeNodeStack(element.id)
        instantaneus.state = stack.state;
        instantaneus.input.shift()
        instantaneus.stack.shift()
      } catch (error) {
        return errorState()
      }
    }
    state.innerText = stack.state
    instantaneusList.push(getInstantaneus(instantaneus))
    printInstantaneus(instantaneus)
    await sleep(1500)
    move()
    counter++; 
  }

  state.innerText = 'f'
  instantaneus.state = 'f'
  instantaneus.input.push('e')
  instantaneusList.push(getInstantaneus(instantaneus))
  printInstantaneus(instantaneus)
  if(stack.isEmpty()) {
    fetch('/instantaneus', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ instantaneus: instantaneusList.join(' ') })
    })
    return successState()
  }
  else return errorState()

}
