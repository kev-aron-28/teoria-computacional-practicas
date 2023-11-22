const express = require('express');
const app = express();
const port = 3000; // You can use any port you prefer
const fs = require('fs');

// Serve static content from the 'public' directory
app.use(express.static('public'));
app.use(express.json())

app.post('/instantaneus', (req, res) => {
  const contentToAppend = req.body.instantaneus
  fs.appendFile('file.txt', contentToAppend, (err) => {
    if (err) {
        console.error(`Error appending`);
    } else {
        console.log(`Content appended`);
    }
});
})

app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
});
