from tkinter import *
import matplotlib.pyplot as plt
import networkx as net
from tkinter import messagebox
import random
root = Tk()

class Markup(Entry):
    def __init__(self, parent,c):
        self.value = StringVar()
        Entry.__init__(self, parent, textvariable = self.value, width = 3, justify='center' )
        for i in range(c):
            self.lab1 = Label(parent, font=("Arial", 13))
            self.lab1['text']+= "A%i "%(i+1)
            self.lab1.grid(row=0, column=i + 1)
            self.lab2 = Label(parent, font=("Arial", 13))
            self.lab2['text']+= "A%i"%(i+1)
            self.lab2.grid(row=i+1, column = 0)

class Cells(Frame):
    def __init__(self, parent, columns):
        Frame.__init__(self, parent)
        self.cells = [[Markup(parent,columns) for i in range(columns)] for j in range(columns)]
        [self.cells[i][j].grid(row = i+1, column = j+1) for i in range(columns) for j in range(columns)]
        [self.cells[i][j].insert(0, random.randint(0, 50)) for i in range(columns) for j in range(columns)]

class Window(Cells):
    def __init__(self, menu):
        Cells.__init__(self, menu,0)
        self.menu = menu
        self.menu.geometry('200x200')
        self.menu.title("Лаб3")

        self.lab5 = Label(self.menu, text="Охочий Ростислав", font=("Arial", 12))
        self.lab6 = Label(self.menu, text="Номер ЗК: ІВ-9123", font=("Arial", 12))
        self.lab7 = Label(self.menu, text="Варіант: 4", font=("Arial", 12))
        self.lab = Label(self.menu, text="Кількість вершин:", font=("Arial", 12))
        self.ent = Entry(self.menu, width=5, font=("Arial", 12), justify='center')
        self.but = Button(self.menu, text="Далі", command=self.nextW, font=("Arial", 10), width=10, bg="Black", fg="White")
        self.but1 = Button(self.menu, text="Побудувати граф\nта показати шлях", command=self.audit, font=("Arial", 10), bg="Black", fg="White")
        self.lab2 = Label(self.menu, text="Початок: А", font=("Arial", 10))
        self.ent1 = Entry(self.menu, width=3, font=("Arial", 10), justify='center')
        self.lab3 = Label(self.menu, text="  Кінець: А", font=("Arial", 10))
        self.ent2 = Entry(self.menu, width=3, font=("Arial", 10), justify='center')

        self.lab5.place(x=0, y=5)
        self.lab6.place(x=0, y=35)
        self.lab7.place(x=0, y=65)
        self.lab.place(x=0, y=95)
        self.but.place(x=60, y=130)
        self.ent.place(x=130, y=95)

        self.menu.mainloop()

    def nextW(self):
        c = int(self.ent.get())
        self.lab5.place_forget()
        self.lab6.place_forget()
        self.lab7.place_forget()
        self.lab.place_forget()
        self.ent.place_forget()
        self.but.place_forget()
        self.but1.place(x=10, y=25*(c+1)+75)
        self.lab2.place(x=10, y=25*(c+1)+15)
        self.ent1.place(x=78, y=25*(c+1)+15)
        self.lab3.place(x=10, y=25*(c+1)+35)
        self.ent2.place(x=78, y=25*(c+1)+35)

        try:
            self.tab = Cells(self.menu, c)
            self.tab.pack()
        except TclError:
            pass
        self.menu.geometry("%dx%d" % (40*c + 25, 30*(c+1)+120))

    def audit(self):
        if self.ent1.get() == "" and self.ent2.get() == "":
            messagebox.showerror("Помилка","Будь ласка, заповніть усі поля")
        else:
            c = int(self.ent.get())
            self.l = []
            for i in range(c):
                self.l.append([])
                for j in range(c):
                    self.l[i].append(self.tab.cells[i][j].value.get())
            self.Algoritm(c,int(self.ent1.get()),self.l, int(self.ent2.get()))

    def Algoritm(self, N,S,w,Last_Node):
        inf = float("inf")
        dist = [inf] * N
        dist[S-1] = 0
        prev = [None] * N
        used = [False] * N
        min_dist = 0
        min_vertex = S-1
        try:
            while min_dist < inf:
                i = min_vertex
                used[i] = True
                for j in range(N):
                    if w[i][j] == "inf":
                        w[i][j] = inf
                        if dist[i] + float(w[i][j]) < dist[j]:
                            dist[j] = dist[i] + float(w[i][j])
                            prev[j] = i
                    else:
                        if dist[i] + float(w[i][j]) < dist[j]:
                            dist[j] = dist[i] + float(w[i][j])
                            prev[j] = i
                min_dist = inf
                for j in range(N):
                    if not used[j] and dist[j] < min_dist:
                        min_dist = dist[j]
                        min_vertex = j
            path = []
            j= Last_Node-1
            while j is not None:
                path.append(j)
                j = prev[j]
            path = path[::-1]
            print(path)
            result =[]
            for i in range(len(path)-1):
                result.append(("A%i"%(path[i]+1),"A%i"%(path[i+1]+1)))

            plt.figure(1)
            self.graph = net.DiGraph()
            for i in range(N):
                self.graph.add_node("A%i"%(i+1))
            for i in range (len(w)):
                for j in range(len(w[i])):
                    if w[i][j] == inf:
                        continue
                    else:
                        self.graph.add_edge("A%i"%(i+1),"A%i"%(j+1), weight = w[i][j])
            net.draw(self.graph, pos=net.shell_layout(self.graph), arrows=True, with_labels=True, node_size=100, width=3,font_size=13, font_family="Arial")
            edge_labels=dict([((u,v,),d['weight'])
                 for u,v,d in self.graph.edges(data=True)])
            net.draw_networkx_edge_labels(self.graph, pos=net.shell_layout(self.graph),edge_labels=edge_labels, label_pos=0.3, font_size=9)
            net.draw_networkx_edges(self.graph, pos=net.shell_layout(self.graph), edgelist=result, edge_color='r', arrows=True, with_labels=True, width=5)
            plt.savefig(r"Graph1.png")
            plt.show()
        except ValueError:
            messagebox.showerror("Помилка","Матриця заповнена не повністю")

c = Window(root)
