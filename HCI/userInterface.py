from tkinter import *
from functools import partial
def validatelogin(username,email,var1,var2,password):
    print("username entered :",username.get())
    print("email entered :",email.get())
    print("gender entered :",var1.get(),var2.get())
    print("password :",password.get())
    lognSucess = Label(tkWindow, text="Login Sucessful").grid(row=5, column=0)
    return
def clearLogin(username,email,var1,var2,password): 
    usernameEntry.delete(0,'end')
    emailEntery.delete(0,'end')
    passwordEntry.delete(0, 'end')
    return

#Window
tkWindow=Tk()
tkWindow.geometry('500x150')
tkWindow.title("Tkinker login form")

#username label and entry box
usernamelabel=Label(tkWindow,text="user name").grid(row=0,column=0)
username=StringVar()
usernameEntry=Entry(tkWindow,textvariable=username).grid(row=0,column=1)

#email label and entry box
emaillabel=Label(tkWindow,text="email").grid(row=1,column=0)
email=StringVar()
emailEntery=Entry(tkWindow,textvariable=email).grid(row=1,column=1)

#gender check box
var1=IntVar()
Checkbutton(tkWindow,text="male",variable=var1).grid(row=2,column=0)
var2=IntVar()
Checkbutton(tkWindow,text="female",variable=var2).grid(row=3,column=0)

#password and password box
passwordlabel=Label(tkWindow,text="password").grid(row=4,column=0)
password=StringVar()
passwordEntry=Entry(tkWindow,show="*",textvariable=password).grid(row=4,column=1)

validatelogin=partial(validatelogin,username,email,var1,var2,password)
clearLogin = partial(clearLogin, username,email,var1,var2, password)

#login button
loginButton = Button(tkWindow, text="Login", command=validatelogin).grid(row=5, column=0)
#cancel button
cancelButton = Button(tkWindow, text="Clear", command=clearLogin).grid(row=5, column=1)
tkWindow.mainloop()
