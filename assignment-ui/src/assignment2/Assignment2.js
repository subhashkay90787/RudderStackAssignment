import React from 'react'
import './Assignment2.css'
import * as yup from 'yup'
import axios from 'axios';
export class Assignment2 extends React.Component{

    constructor(props) {
        super(props);
        this.state={
            name:"",
            description:"",
            events:[],
            eventName: "",
            eventDescription:"",
            eventRules: "",
            error:false,
            errorMessage:""
        }
    }

    render(){
        return(
            <div className='assignment'>
                
                <div className='form'>
                <b>Assignment 2</b>
                <br/>
                <div>
                    <label>
                        Name 
                        <div>
                            <input value={this.state.name} onChange={(e)=>{this.setState({name:e.target.value})}}/>
                        </div>
                    </label>
                </div>
                <div>
                    <label>
                        Description
                        <div>
                            <input value={this.state.description} onChange={(e)=>{
                            this.setState({description:e.target.value})        
                        }}/>
                        </div>

                    </label>
                </div>
                <div className='eventForm'>
                <div> 
                    <label>
                        Name 
                        <div>
                            <input value={this.state.eventName} onChange={(e)=>{this.setState({eventName:e.target.value})}}/>
                        </div>
                    </label>
                </div>
                 <div>    
                    <label>
                        Description
                        <div>
                            <input value={this.state.eventDescription} onChange={(e)=>{this.setState({eventDescription:e.target.value})}}/>
                        </div>
                    </label>
                </div>
                <div>
                    <label>
                        Rules 
                        <div>
                            <input type="textarea" value={this.state.eventRules} onChange={(e)=>{this.setState({eventRules:e.target.value})}}/>
                        </div>
                    </label>
                </div>
                <div>
                    {this.state.events.length==0?"":
                    
                    <table>
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Rules</th>
                                <th>Delete</th>
                            </tr>   
                        </thead> 
                        <tbody>
                            {
                                this.state.events.map((elem,index,arr)=>{
                                    return(
                                        <tr>
                                            <td>{JSON.stringify(elem['name'])}</td>
                                            <td>{JSON.stringify(elem['description'])}</td>
                                            <td>{JSON.stringify(elem['rules'])}</td>
                                            <td><button onClick={()=>{
                                                arr.splice(index,1);
                                                this.setState({events:arr});
                                            }}>-</button></td>
                                        </tr>
                                    )
                                })
                            }
                        </tbody>
                    </table>
                     }
                </div>               
                <div>   
                    <button onClick={()=>{
                        var rules = ""
                        try{
                            rules = JSON.parse(this.state.eventRules)
                        }catch(e){
                            console.error(e);
                        }

                        const event={
                            "name":this.state.eventName,
                            "description":this.state.eventDescription,
                            "rules": rules
                        }
                    
                    
                        this.setState({
                            events:[...this.state.events,event],
                            eventDescription:"",
                            eventName:"",
                            eventRules:""
                        });


                    }}>+</button> 
                </div>
                </div>
                    {this.state.error?<div className='errorMessage'>{this.state.errorMessage}</div>:""}
                    <button onClick={()=>{
                        const event={
                            "name":this.state.name,
                            "events":this.state.events
                        }
                        const eventSchema = yup.object({
                            name : yup.string().matches(/^[a-z0-9A-Z]+$/).required(),
                            description: yup.string().nullable(),
                            events: yup.array(yup.object({
                                name: yup.string(),
                                description: yup.string().nullable(),
                                rules:yup.object().required()
                            }))
                        })
                        eventSchema.validate(event).then(resp=>{
                            console.log(resp);
                            axios.post("/api/trackingPlan/add",resp).then((resp)=>{
                                this.setState({
                                    name:"",
                                    description:"",
                                    events:[],
                                    eventName: "",
                                    eventDescription:"",
                                    eventRules: "",
                                    error:false,
                                    errorMessage:""
                                });
                                alert("Successfully submitted tracking plan")
                            }).catch(err=>{
                                this.setState({error:true,errorMessage:err.message});
                            })
                            
                        }).catch(err=>{
                            this.setState({error:true,errorMessage:err.message})
                        })

                    }}>Submit</button>
                </div>
            </div>
        )
    }
}