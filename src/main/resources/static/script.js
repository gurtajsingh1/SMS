// Load students on page load
document.addEventListener('DOMContentLoaded', loadStudents);

function loadStudents() {
    fetch('/students')
        .then(response => response.json())
        .then(students => {
            const tbody = document.getElementById('studentTable');
            tbody.innerHTML = '';
            students.forEach(student => {
                const row = `
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.email}</td>
                        <td>${student.cource}</td>
                        <td>$${student.fee}</td>
                        <td>
                            <button class="btn btn-danger" onclick="deleteStudent(${student.id})">🗑️ Delete</button>
                        </td>
                    </tr>
                `;
                tbody.innerHTML += row;
            });
        })
        .catch(error => console.error('Error loading students:', error));
}

function openModal() {
    document.getElementById('studentForm').reset();
    document.getElementById('studentId').value = '';
    document.getElementById('modalTitle').textContent = 'Add New Student';
    document.getElementById('studentModal').style.display = 'block';
}

function closeModal() {
    document.getElementById('studentModal').style.display = 'none';
}

document.getElementById('studentForm').addEventListener('submit', function(e) {
    e.preventDefault();
    
    const id = document.getElementById('studentId').value;
    const student = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        cource: document.getElementById('cource').value,
        fee: parseFloat(document.getElementById('fee').value)
    };

    const method = id ? 'PUT' : 'POST';
    const url = id ? '/students/' + id : '/students';

    fetch(url, {
        method: method,
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(student)
    })
    .then(response => response.json())
    .then(data => {
        closeModal();
        loadStudents();
    })
    .catch(error => console.error('Error saving student:', error));
});

function deleteStudent(id) {
    if (confirm('Are you sure you want to delete this student?')) {
        fetch('/students/' + id, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                loadStudents();
            }
        })
        .catch(error => console.error('Error deleting student:', error));
    }
}

// Close modal when clicking outside
window.onclick = function(event) {
    const modal = document.getElementById('studentModal');
    if (event.target == modal) {
        closeModal();
    }
}

