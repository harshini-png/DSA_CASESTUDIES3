# 🚀 DSA Case Studies – AVL Tree, Fenwick Tree, BFS

## 📌 Project Overview
This repository contains three real-world Data Structure case studies implemented in Java.  
Each module demonstrates how advanced data structures are used in large-scale systems for efficient computation.

---

# 📁 Case Studies Included

## 🧠 CO1 – AVL Tree Leaderboard System (QuizClash)

### 📖 Description
Implements a real-time gaming leaderboard using an **AVL Tree with rank augmentation (subtree size)**.

### ⚙️ Features
- Insert and delete player scores  
- Self-balancing AVL Tree (LL, RR, LR, RL rotations)  
- Rank calculation in O(log n)  
- Dynamic leaderboard updates  

### 🧠 Data Structure
- AVL Tree  
- Rank-augmented nodes  

### ⏱️ Complexity
- Insert: O(log n)  
- Delete: O(log n)  
- Rank Query: O(log n)

---

## 🏦 CO2 – Fenwick Tree (HDFC NetBanking System)

### 📖 Description
Simulates banking daily spend tracking using a **Fenwick Tree (Binary Indexed Tree)**.

### ⚙️ Features
- Point updates for transactions  
- Prefix sum queries  
- Range sum (monthly statements)  
- Efficient batch processing  

### 🧠 Data Structure
- Fenwick Tree (BIT)  
- 1D array representation  

### ⏱️ Complexity
- Update: O(log n)  
- Query: O(log n)

---

## 🐦 CO3 – BFS Reach Prediction (X / Twitter)

### 📖 Description
Implements **bounded BFS (depth ≤ 3)** to predict tweet reach in a social network graph.

### ⚙️ Features
- BFS traversal from source user  
- Depth-limited exploration  
- Visited set to avoid duplicates  
- Real-time reach computation  

### 🧠 Data Structure
- Graph (Adjacency List)  
- Queue (BFS)  
- HashSet (Visited nodes)

### ⏱️ Complexity
- O(V + E)

---

# 📂 Project Structure
